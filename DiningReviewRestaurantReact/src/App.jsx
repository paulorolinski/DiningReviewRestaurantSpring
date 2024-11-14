import { Link, BrowserRouter as Router } from "react-router-dom";
import AppRoutes from "./router/AppRoutes";
import "./App.css";

function App() {
  return (
    <>
      <Router>
          <AppRoutes></AppRoutes>
      </Router>
    </>
  );
}

export default App;
