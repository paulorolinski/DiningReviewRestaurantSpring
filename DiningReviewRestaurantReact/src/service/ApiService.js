import axios from "axios";

const token = document.cookie
.split("; ")
.find((row) => row.startsWith("token="))
?.split("=")[1];

const apiClient = axios.create({
  baseURL: import.meta.env.VITE_API_URL,
  headers: {
    Accept: "application/json",
    "Content-Type": "application/json",
    "Authorization": `Bearer ${token}`
  },
});

export default apiClient;
