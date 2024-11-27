import checkToken from "./checkToken";

export default function isAuthenticated() {
    return true ? checkToken() : false;
}