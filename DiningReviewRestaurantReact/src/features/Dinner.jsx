import useDinners from "../hooks/dinner";
export default function Review() {
  const { dinners } = useDinners();
  return (
    <>
      <header>
        <a href="/">
          <img
            src="https://cdn-icons-png.flaticon.com/512/5774/5774594.png"
            alt="voltar"
            style={{ width: 50, height: 50 }}
          />
        </a>
        <h1>Dinners</h1>
      </header>
      <ul>
        {dinners.map((dinner) => (
          <li className="itemLista" key={dinner.id}>
            {dinner.name}: {dinner.price}
          </li>
        ))}
      </ul>
    </>
  );
}
