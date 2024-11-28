import { RouterProvider } from "react-router-dom";
import router from "./router/Router";
import "./App.css";

function App() {
  return (
    <>
      {/* <div className="background">
      <div className="background-item" style={{"--i": 1}}></div>
      <div className="background-item" style={{"--i": 2}}></div>
      <div className="background-item" style={{"--i": 3}}></div>
      <div className="background-item" style={{"--i": 4}}></div>
      <div className="background-item" style={{"--i": 5}}></div>
      <div className="background-item" style={{"--i": 6}}></div>
      <div className="background-item" style={{"--i": 7}}></div>
      <div className="background-item" style={{"--i": 8}}></div>
      <div className="background-item" style={{"--i": 9}}></div>
      <div className="background-item" style={{"--i": 10}}></div>
      <div className="background-item" style={{"--i": 11}}></div>
      <div className="background-item" style={{"--i": 12}}></div>
      <div className="background-item" style={{"--i": 13}}></div>
      <div className="background-item" style={{"--i": 14}}></div>
      <div className="background-item" style={{"--i": 15}}></div>
      <div className="background-item" style={{"--i": 16}}></div>
      <div className="background-item" style={{"--i": 17}}></div>
      <div className="background-item" style={{"--i": 18}}></div>
      <div className="background-item" style={{"--i": 19}}></div>
      <div className="background-item" style={{"--i": 20}}></div>
      <div className="background-item" style={{"--i": 21}}></div>
    </div> */}
      <div className="logo react"></div>
      <RouterProvider router={router} />
    </>
  );
}

export default App;
