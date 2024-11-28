import "../assets/login.css";
import { RiLockPasswordFill } from "react-icons/ri";
import { MdAlternateEmail } from "react-icons/md";
import signIn from "../service/auth/signIn";
import { useNavigate } from "react-router-dom";
import { useState } from "react";
import Unauthorized from "../components/Unauthorized";
import checkToken from "../service/auth/checkToken";

export default function Login() {
  const navigate = useNavigate();
  const { opened } = location.state || { opened: false };
  const [open, setOpen] = useState(opened);

  async function handleSubmit(e) {
    e.preventDefault();
    const login = e.target.loguser.value;
    const password = e.target.logpass.value;
    const success = await signIn(login, password);
    if (success && checkToken()) {
      navigate("/restaurants")
    } else {
      setOpen(true);
    }
  }

  return (
    <>
      <div className="content">
        <div className={"card-login"}>
          <p className="title">Log In!</p>
          <form onSubmit={handleSubmit} action="post">
            <div className="field">
              <MdAlternateEmail className="input-icon" />
              <input
                type="text"
                name="loguser"
                className="input-field"
                placeholder="Username"
                id="loguser"
                autoComplete="off"
              />
            </div>
            <div className="field">
              <RiLockPasswordFill className="input-icon" />
              <input
                type="password"
                name="logpass"
                className="input-field"
                placeholder="Password"
                id="logpass"
                autoComplete="off"
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
      {open && <Unauthorized open={open} setOpen={setOpen} />}
    </>
  );
}
