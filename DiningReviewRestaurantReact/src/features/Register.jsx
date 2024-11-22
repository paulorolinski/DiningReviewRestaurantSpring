import "../assets/login.css";
import Pyramid from "../components/Pyramid";
import { BsFillTelephoneFill } from "react-icons/bs";
import { MdEmail } from "react-icons/md";
import { RiLockPasswordFill } from "react-icons/ri";
import { MdAlternateEmail } from "react-icons/md";
import Unauthorized from "../components/Unauthorized";

export default function Login() {
  return (
    <>
    <Unauthorized />
      <div className="content">
        <div className="card-login">
          <p className="title">Register</p>
          <form>
            <div className="field">
            <MdAlternateEmail className="input-icon"/>
              <input
                type="text"
                name="logemail"
                className="input-field"
                placeholder="Username"
                id="logemail"
                autocomplete="off"
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
                autocomplete="off"
              />
            </div>
            <div className="field">
                <BsFillTelephoneFill className="input-icon"/>
              <input
                type="tel"
                name="logTel"
                className="input-field"
                placeholder="Telefone"
                id="logTel"
                autocomplete="off"
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
                autocomplete="off"
              />
            </div>
            <div className="field">
            <RiLockPasswordFill className="input-icon"/>
              <input
                type="password"
                name="logpass"
                className="input-field"
                placeholder="Repeat password"
                id="logpass"
                autocomplete="off"
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
        <Pyramid />
      </div>
    </>
  );
}
