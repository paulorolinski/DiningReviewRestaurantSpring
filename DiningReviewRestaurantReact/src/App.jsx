import { RouterProvider } from "react-router-dom";
import router from "./router/Router";
import "./App.css";

function App() {
  return (
    <>
      <div className="logo react"></div>
      <RouterProvider router={router} />
    </>
  );
}

export default App;
