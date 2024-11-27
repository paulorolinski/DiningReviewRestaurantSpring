import apiAuth from "../ApiAuth";

async function signIn(login, password) {
  try {
    const response = apiAuth.post("/auth/login", {
      login,
      password,
    });
    const token = (await response).data.token;
    document.cookie = `token=${token}`;
  } catch (e) {
    console.log("Deslogado");
  }
}

export default signIn;
