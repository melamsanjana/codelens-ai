import { useState } from "react";
import api from "../services/api";

function CodeReview() {

  const [code, setCode] = useState("");
  const [result, setResult] = useState("");

  const review = async () => {
    try {
      const res = await api.post("/ai/review-code", { code });
      setResult(res.data);
    } 
   catch (err) {
    console.log(err);

    if (err.response) {
        console.log("Status:", err.response.status);
        console.log("Data:", err.response.data);

        alert(JSON.stringify(err.response.data, null, 2));
    } else {
        alert(err.message);
    }
  if (err.response) {
    console.log(err.response.data);
    alert(JSON.stringify(err.response.data));
  } else {
    alert(err.message);
  }
}
  };

  return (
    <div style={{ padding: "30px" }}>
      <h1>AI Code Review</h1>

      <textarea
        rows="10"
        cols="90"
        value={code}
        onChange={(e) => setCode(e.target.value)}
      />

      <br /><br />

      <button onClick={review}>Review Code</button>

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

export default CodeReview;