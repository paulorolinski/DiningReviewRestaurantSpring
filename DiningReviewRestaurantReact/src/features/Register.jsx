import "../assets/login.css";
import { BsFillTelephoneFill } from "react-icons/bs";
import { MdEmail } from "react-icons/md";
import { RiLockPasswordFill } from "react-icons/ri";
import { MdAlternateEmail } from "react-icons/md";
import { useState } from "react";
import signUp from "../service/auth/signUp";
import LoginError from "../components/LoginError";
import LoginSuccess from "../components/CadastroSuccess";
import signIn from "../service/auth/signIn";
import { useNavigate } from "react-router-dom";
import checkToken from "../service/auth/checkToken";

export default function Register() {
  const { opened } = location.state || { opened: false };
  const { openedSuccess } = location.state || { openedSuccess: false };
  const [openError, setOpenError] = useState(opened);
  const [openSuccess, setOpenSuccess] = useState(openedSuccess);
  const navigate = useNavigate();

  async function handleSubmit(e) {
    e.preventDefault();
    const login = e.target.login.value;
    const email = e.target.logEmail.value;
    const phone = e.target.logTel.value;
    const password = e.target.logPass.value;
    const verPass = e.target.logVerPass.value;

    if(password == verPass) {
      await signUp(login, password, phone, email)
      const success = await signIn(login, password);
      if (success && checkToken()) {
        setOpenSuccess(true)
      } else {
        setOpenError(true)
      }
    } else {
      setOpenError(true)
    }
  }

  return (
    <>
      <div className="content-register">
        <button className="loginBotao">
          <span className="text" onClick={() => navigate("/login")}>Login</span>
        </button>
      </div>
      <div className="content">
        <div className="card-login">
          <p className="title">Register</p>
          <form onSubmit={handleSubmit} action="post">
            <div className="field">
              <MdAlternateEmail className="input-icon" />
              <input
                type="text"
                name="login"
                className="input-field"
                placeholder="Username"
                id="login"
                autoComplete="off"
                required
              />
            </div>
            <div className="field">
              <MdEmail className="input-icon" />
              <input
                type="email"
                name="logemail"
                className="input-field"
                placeholder="Email"
                id="logEmail"
                autoComplete="off"
                required
              />
            </div>
            <div className="field">
              <BsFillTelephoneFill className="input-icon" />
              <input
                type="tel"
                name="logTel"
                className="input-field"
                placeholder="Telefone"
                id="logTel"
                autoComplete="off"
                required
              />
            </div>
            <div className="field">
              <RiLockPasswordFill className="input-icon" />
              <input
                type="password"
                name="logpass"
                className="input-field"
                placeholder="Password"
                id="logPass"
                autoComplete="off"
                required
              />
            </div>
            <div className="field">
              <RiLockPasswordFill className="input-icon" />
              <input
                type="password"
                name="logpass"
                className="input-field"
                placeholder="Repeat password"
                id="logVerPass"
                autoComplete="off"
                required
              />
            </div>
            <button type="submit" className="btn">
              Login
            </button>
            <a className="btn-link" href="#">
              Forgot your password?
            </a>
          </form>
        </div>
      </div>
      {openSuccess && (
        <LoginSuccess open={openSuccess} setOpen={setOpenSuccess} />
      )}
      {openError && <LoginError open={openError} setOpen={setOpenError} />}
    </>
  );
}
