export default function checkToken() {
  const token = document.cookie.split('; ').find(row => row.startsWith('token=')); 
  return !!token;
}
