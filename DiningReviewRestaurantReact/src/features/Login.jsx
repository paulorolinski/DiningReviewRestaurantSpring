import "../assets/login.css";
import Pyramid from "../components/Pyramid";
import { RiLockPasswordFill } from "react-icons/ri";
import { MdAlternateEmail } from "react-icons/md";
import { useState } from "react";

export default function Login() {
    const [a,setA] = useState(false)
    setTimeout(() => {
        setA(true)
    }, 3000);
  return (
    <>
      <div className="content">
        <div className={`card-login ${a ? 'a' : undefined}`}>
          <p className="title">Log In!</p>
          <form>
            <div className="field">
            <MdAlternateEmail className="input-icon"/>
              <input
                type="text"
                name="loguser"
                className="input-field"
                placeholder="Username"
                id="loguser"
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
