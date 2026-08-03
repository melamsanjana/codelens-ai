import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import api from "../services/api";

function Register() {

  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const navigate = useNavigate();

  const register = async () => {

    try {

      const response = await api.post("/auth/register", {
        name,
        email,
        password,
      });

      console.log(response.data);

      alert("Registration Successful!");

      navigate("/");

    } catch (err) {

      console.log(err);

      if (err.response) {
        alert(err.response.data.message || "Registration Failed");
      } else {
        alert("Network Error");
      }

    }

  };

  return (
    <div style={{ textAlign: "center", marginTop: "80px" }}>

      <h1>Register</h1>

      <input
        type="text"
        placeholder="Name"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />

      <br /><br />

      <input
        type="email"
        placeholder="Email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />

      <br /><br />

      <input
        type="password"
        placeholder="Password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />

      <br /><br />

      <button onClick={register}>
        Register
      </button>

      <br /><br />

      <Link to="/">Already have an account? Login</Link>

    </div>
  );
}

export default Register;