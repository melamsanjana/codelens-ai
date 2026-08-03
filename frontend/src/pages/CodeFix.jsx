import { useState } from "react";
import api from "../services/api";

function CodeFix() {

  const [code, setCode] = useState("");
  const [result, setResult] = useState("");

  const fix = async () => {
    try {
      const res = await api.post("/ai/fix-code", { code });
      setResult(res.data);
    } catch (e) {
      alert("Fix Failed");
    }
  };

  return (
    <div style={{ padding: "30px" }}>
      <h1>AI Code Fix</h1>

      <textarea
        rows="10"
        cols="90"
        value={code}
        onChange={(e) => setCode(e.target.value)}
      />

      <br /><br />

      <button onClick={fix}>Fix Code</button>

      <br /><br />

      <textarea
        rows="15"
        cols="90"
        value={result}
        readOnly
      />
    </div>
  );
}

export default CodeFix;