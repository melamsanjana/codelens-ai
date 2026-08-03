import { useState } from "react";
import api from "../services/api";
import "../App.css";

function ErrorAnalyzer() {

  const [error, setError] = useState("");
  const [result, setResult] = useState("");

  const analyzeError = async () => {
    try {

      const response = await api.post("/ai/explain-error", {
        error: error
      });

      setResult(response.data);

    } catch (err) {
      console.log(err);
      setResult("Unable to connect to AI Service.");
    }
  };

  return (
    <div className="container">

      <h1>🧠 CodeLens AI</h1>

      <p className="subtitle">
        Paste your programming error below and get an explanation.
      </p>

      <textarea
        placeholder="Example: NullPointerException at line 15"
        value={error}
        onChange={(e) => setError(e.target.value)}
      />

      <button onClick={analyzeError}>
        Analyze Error
      </button>

      <h2>AI Explanation</h2>

      <div className="result">
        {result}
      </div>

    </div>
  );
}

export default ErrorAnalyzer;