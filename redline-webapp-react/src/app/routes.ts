import { createBrowserRouter } from "react-router";
// import App from "../App";
import Home from "./home/page";
import App from "./layout";
import UserEdit from "./user/user-edit";
import User from "./user/user";

const router = createBrowserRouter([
  {
    Component: App,
    children: [
      { index: true, Component: Home },

      {
        path: "user",
        children: [
          { index: true, Component: User },
          { path: ":id", Component: UserEdit },
        ],
      },
    ],
  },
]);

export default router;
