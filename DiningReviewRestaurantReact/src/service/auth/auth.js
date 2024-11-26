import axios from "axios";

const apiClient = axios.create({
    baseURL: import.meta.env.VITE_API_URL,
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
})

async function signIn(login, password) {
    try {
        const response = apiClient.post("/auth/login", {
           login, password
          });
          const token = (await response).data.token
          document.cookie = `token=${token}`
    } catch(e) {
        console.log("Deslogado");
    }
}

export default signIn;
