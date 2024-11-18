import Header from "../components/Header";
import { useLocation } from "react-router-dom";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

export default function Review() {
  const location = useLocation();
  const { selectedRestaurant } = location.state || {};
  const [selectedPlate, setSelectedPlate] = useState(null)
  const navigate = useNavigate()

  const handleCardClick = (plate) => {
    setSelectedPlate(plate)
    navigate("/reviews", { state: { selectedPlate: plate } });
  }

  return (
    <>
      <Header></Header>
      <h2>
        Jantares em <a style={{ color: "red" }}>{selectedRestaurant.name}</a>
      </h2>
      <div style={{ margin: 100 }} className="flex-container">
        {selectedRestaurant.plates != 0 ? (
          <div className="cards">
            {selectedRestaurant.plates.map((plate) => (
              <div className="card" key={plate.id} onClick={() => handleCardClick(plate)}>
                <img
                  className="img"
                  src={plate.imgUrl}
                  style={{ width: 250 }}
                />
                <div>
                  <h4>
                    <b>{plate.name}</b>
                  </h4>
                  <p>{plate.price} reais</p>
                </div>
              </div>
            ))}
          </div>
        ) : (
          <p>Não existem jantares registrados nesse Restaurante</p>
        )}
      </div>
    </>
  );
}
