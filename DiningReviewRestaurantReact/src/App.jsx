import { useEffect, useState } from 'react'
import './App.css'

function App() {
  const API_URL = "http://localhost:8080/users"
  const [count, setCount] = useState(0)
  const [users, setUsers] = useState([])

  useEffect(() => {
    fetch(API_URL).then(response => response.json()).then(data => setUsers(data)).catch(error => console.error("Erro ao buscar users", error));
  }, [])

  return (
    <>
      <h1 class="title">Reviews</h1>
      <ul>
        {users.map(user => (
          <li className="itemLista" key={user.id}>{user.name}</li>
        ))}
      </ul>
    </>
  )
}

export default App
