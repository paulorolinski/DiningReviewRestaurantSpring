import { useEffect, useState } from 'react'
import './App.css'

function App() {
  const API_URL = import.meta.env.API_URL
  console.log(API_URL)
  const [users, setUsers] = useState([])

  useEffect(() => {
    fetch(`${API_URL}/reviews`)
    .then(response => response.json())
    .then(data => setUsers(data))
    .catch(error => console.error("Erro ao buscar users", error));
  }, [])

  return (
    <>
      <h1 className="title">Reviews</h1>
      <ul>
        {users.map(review => (
          <li className="itemLista" key={review.id}>{review.user.name}: {review.comment}</li>
        ))}
      </ul>
    </>
  )
}

export default App
