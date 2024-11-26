import "../assets/login.css";
import { BsFillTelephoneFill } from "react-icons/bs";
import { MdEmail } from "react-icons/md";
import { RiLockPasswordFill } from "react-icons/ri";
import { MdAlternateEmail } from "react-icons/md";

export default function Register() {
  function handleSubmit(e) {
    e.preventDefault()
    const login = e.target.login.value
    const email = e.target.logemail.value
    const tel = e.target.logtel.value
    const pass = e.target.logpass.value
    const verPass = e.target.logverpass.value
    console.log(login, email, tel, pass, verPass);
  }
  return (
    <>
      <div className="content">
        <div className="card-login">
          <p className="title">Register</p>
          <form onSubmit={handleSubmit} action="post">
            <div className="field">
            <MdAlternateEmail className="input-icon"/>
              <input
                type="text"
                name="login"
                className="input-field"
                placeholder="Username"
                id="login"
                autoComplete="off"
              />
            </div>
            <div className="field">
            <MdEmail className="input-icon"/>
              <input
                type="text"
                name="logemail"
                className="input-field"
                placeholder="Email"
                id="logemail"
                autoComplete="off"
              />
            </div>
            <div className="field">
                <BsFillTelephoneFill className="input-icon"/>
              <input
                type="tel"
                name="logTel"
                className="input-field"
                placeholder="Telefone"
                id="logtel"
                autoComplete="off"
              />
            </div>
            <div className="field">
            <RiLockPasswordFill className="input-icon"/>
              <input
                type="password"
                name="logpass"
                className="input-field"
                placeholder="Password"
                id="logpass"
                autoComplete="off"
                required
              />
            </div>
            <div className="field">
            <RiLockPasswordFill className="input-icon"/>
              <input
                type="password"
                name="logpass"
                className="input-field"
                placeholder="Repeat password"
                id="logverpass"
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
    </>
  );
}
