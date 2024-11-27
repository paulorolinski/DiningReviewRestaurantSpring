import apiAuth from "../ApiAuth";

async function signUp(login, password, phone, email) {
  try {
    apiAuth.post("/auth/register", {
      login: login,
      password: password,
      phone: phone,
      email: email,
      role: "USER",
    });
  } catch (e) {
    console.log("Não foi possível criar um novo usuário");
  }
}

export default signUp;
