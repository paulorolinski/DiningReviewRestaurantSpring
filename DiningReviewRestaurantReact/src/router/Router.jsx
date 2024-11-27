import { createBrowserRouter } from "react-router-dom";
import Login from "../features/Login";
import Register from "../features/Register";
import Restaurant from "../features/Restaurant";
import Dinner from "../features/Dinner";
import Review from "../features/Review";
// import Login from "../features/Login";
import Home from "../features/Home";
import NotFound from "../features/NotFound";
import ProtectedRoute from "./ProtectedRoute";
import isAuthenticated from "../service/auth/isAuthenticated";

const Authenticated = () => {
  return isAuthenticated()
};

const router = createBrowserRouter([
  {
    path: "/",
    element: <Home />,
    index: true,
  },
  {
    path: "/login",
    element: <Login />,
    index: true,
  },
  {
    path: "/register",
    element: <Register />,
    index: true,
  },
  {
    element: <ProtectedRoute isAuthenticated={Authenticated()} />,
    children: [
      {
        path: "/restaurants",
        element: <Restaurant />,
      },
      {
        path: "/dinners",
        element: <Dinner />,
      },
      {
        path: "/reviews",
        element: <Review />,
      },
    ],
  },
  {
    path: "*",
    element: <NotFound />,
  },
]);

export default router;
