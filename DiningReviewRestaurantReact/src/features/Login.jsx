import "../assets/login.css";
import Pyramid from "../components/Pyramid";
import { RiLockPasswordFill } from "react-icons/ri";
import { MdAlternateEmail } from "react-icons/md";
import signIn from "../service/auth/auth";
import { useMutation } from "@tanstack/react-query";
import { useNavigate } from "react-router-dom";
import { useState } from "react";
import Anauthorized from "../components/Unauthorized"

export default function Login() {
  const[open, setOpen] = useState(false)
    function popup() {
        setOpen(true);
    }
    
  const [error, setError] = useState(false)

  function handleSubmit(e) {
    e.preventDefault()
    const login = e.target.loguser.value
    const password = e.target.logpass.value
    signIn(login, password)
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
        <Pyramid />
      </div>
    </>
  );
}
