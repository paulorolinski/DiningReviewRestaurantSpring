import { FaPowerOff } from "react-icons/fa";
import "../assets/logout.css";
import { useNavigate } from "react-router-dom";

export default function Logout() {
  const navigate = useNavigate();
  function logout() {
    document.cookie = "token=; Max-Age=0";
    navigate("/login");
  }
  return (
    <>
      <div className="container" onClick={logout}>
        <div className="content-botao">
          <FaPowerOff className="logout" size={30} />
          <h2>Logout</h2>
        </div>
      </div>
    </>
  );
}
