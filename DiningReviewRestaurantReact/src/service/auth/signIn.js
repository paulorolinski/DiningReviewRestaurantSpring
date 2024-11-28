import apiAuth from "../ApiAuth";

async function signIn(login, password) {
  try {
    const response = await apiAuth.post("/auth/login", {
      login,
      password,
    });
    const token = response.data.token;
    document.cookie = `token=${token}`;
    return true
  } catch (e) {
    console.log("Deslogado");
    return false
  }
}

export default signIn;
