import { useState } from "react";
import apiClient from "../ApiService";

async function signIn(login, password) {
    try {
        const response = apiClient.post("/auth/login", {
            login: login,
            password: password,
          });
          const token = (await response).data.token
          console.log("logado" + token);
    } catch (e) {
        console.log(e);
    }
}

export default signIn;
