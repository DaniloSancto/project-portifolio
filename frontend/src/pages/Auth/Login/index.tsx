import ButtonIcon from "../../../components/ButtonIcon";
import "./styles.css";

const Login = () => {
  return (
    <div className="base-card login-container">
      <div className="login-card">
        <h1>LOGIN</h1>
        <form className="form-container">
          <input
            type="text"
            className="base-input"
            placeholder="Email"
            name="username"
          />
          <input
            type="password"
            className="base-input"
            placeholder="Password"
            name="password"
          />
          <div className="button-container">
            <ButtonIcon text="Fazer login" />
          </div>
        </form>
        <div className="signup-container">
          <span className="not-registered">Não tem Cadastro?</span>
          <a href="/admin/auth/register" className="login-link-register">
            CADASTRAR
          </a>
        </div>
      </div>
    </div>
  );
};

export default Login;
