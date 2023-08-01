import { ReactComponent as AuthImage } from "../../assets/images/auth-image.svg";
import Login from "./Login";
import "./styles.css";

const Auth = () => {
  return (
    <div className="auth-container">
      <div className="auth-content">
        <div className="auth-banner-container">
          <h1>Divulgue seus projetos no Portifólio</h1>
          <AuthImage />
        </div>
        <div className="auth-form-container">
          <Login />
        </div>
      </div>
    </div>
  );
};

export default Auth;
