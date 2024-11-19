import useRestaurant from "../hooks/restaurants";
import "../assets/restaurant.css";
import "../components/Header";
import { useNavigate } from "react-router-dom";

export default function Restaurant() {
  const { restaurants } = useRestaurant()
  const navigate = useNavigate()
  

  const handleCardClick = (restaurant) => {
    console.log(restaurant);
    navigate("/dinners", { state: { selectedRestaurant: restaurant } });
  };
  return (
    <>
      <header>
        <h1>Restaurants</h1>
      </header>
      <div style={{ margin: 100 }} className="flex-container">
        <div className="cards">
          {restaurants.map((restaurant) => (
            <div
              className="card"
              key={restaurant.id}
              onClick={() => handleCardClick(restaurant)}
            >
              <img
                className="img"
                src={restaurant.imgUrl}
                style={{ width: 250 }}
              />
              <div>
                <h4>
                  <b>{restaurant.name}</b>
                </h4>
                <p>{restaurant.address}</p>
              </div>
            </div>
          ))}
        </div>
      </div>
    </>
  );
}
