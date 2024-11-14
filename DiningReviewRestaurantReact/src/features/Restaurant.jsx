import useRestaurant from "../hooks/restaurants";
import useDinner from "../hooks/dinner";
import "../assets/restaurant.css";
import { useState } from "react";
export default function Restaurant() {
  const { restaurants } = useRestaurant();
  const { dinners } = useDinner();
  const [selectRestaurant, setSelectRestaurant] = useState(null)

  const handleCardClick = (restaurant) => {
    setSelectRestaurant(restaurant)
    console.log(restaurant);
    
  }
  return (
    <>
      <header>
        <h1>Restaurants</h1>
      </header>
      <div style={{ margin: 100}} className="flex-container">
        <div className="cards">
          {restaurants.map((restaurant) => (
            <div className="card" key={restaurant.id} onClick={() => handleCardClick(restaurant)}>
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
      <div>
      {selectRestaurant && (
          <div className="modal">
            <h2>Dinners at {selectRestaurant.name}</h2>
            <ul>
              {dinners.map(dinner => (
                <li key={dinner.id}>
                  <img src={dinner.imgUrl} alt={dinner.name} />
                  <p>{dinner.name} - ${dinner.price}</p>
                </li>
              ))}
            </ul>
          </div>
        )}
      </div>
    </>
  );
}
