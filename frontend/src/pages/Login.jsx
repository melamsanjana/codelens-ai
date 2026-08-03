import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import api from "../services/api";

function Login() {

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const navigate = useNavigate();

  const login = async () => {

    try {

      const response = await api.post("/auth/login", {
        email,
        password,
      });

      console.log(response.data);

      alert("Login Successful");

      navigate("/dashboard");

    } catch (err) {

      console.log(err);

      if (err.response) {
        alert(err.response.data.message || "Invalid Email or Password");
      } else {
        alert("Network Error");
      }

    }

  };

  return (
    <div style={{ textAlign: "center", marginTop: "80px" }}>

      <h1>Login</h1>

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

      <button onClick={login}>
        Login
      </button>

      <br /><br />

      <Link to="/register">
        Create Account
      </Link>

    </div>
  );
}

export default Login;