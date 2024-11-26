import Header from "../components/Header";
import { useLocation } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import Logout from "../components/Logout";

export default function Review() {
  const location = useLocation();
  const { selectedRestaurant } = location.state || {};
  const navigate = useNavigate();

  const handleCardClick = (plate) => {
    navigate("/reviews", {
      state: { selectedPlate: plate, selectedRestaurant },
    });
  };

  return (
    <>
      <header>
        <div onClick={() => navigate("/restaurants")}>
          <Header></Header>
        </div>
        <h2 className="header">
          Jantares em <a>{selectedRestaurant.name}</a>
        </h2>
        <Logout />
      </header>
      <div style={{ margin: 100 }} className="flex-container">
        {selectedRestaurant.plates != 0 ? (
          <div className="cards">
            {selectedRestaurant.plates.map((plate) => (
              <div
                className="card"
                key={plate.id}
                onClick={() => handleCardClick(plate)}
              >
                <img
                  className="img"
                  src={plate.imgUrl}
                  style={{ width: 250 }}
                />
                <div>
                  <h4>
                    <b>
                      <a>Jantar:</a> {plate.name}
                    </b>
                  </h4>
                  <p>
                    <a>Preço:</a> {plate.price} reais
                  </p>
                </div>
              </div>
            ))}
          </div>
        ) : (
          <p className="not-exists">
            Não existem jantares registrados nesse Restaurante
          </p>
        )}
      </div>
    </>
  );
}
