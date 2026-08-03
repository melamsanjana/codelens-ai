import { Link } from "react-router-dom";

function Dashboard() {

  return (

    <div
      style={{
        textAlign: "center",
        marginTop: "80px"
      }}
    >

      <h1>🚀 Welcome to CodeLens AI</h1>

      <br />

      <Link to="/analyzer">
        <button>Explain Error</button>
      </Link>

      <br /><br />

      <Link to="/review">
        <button>Review Code</button>
      </Link>

      <br /><br />

      <Link to="/fix">
        <button>Fix Code</button>
      </Link>

    </div>

  );

}

export default Dashboard;