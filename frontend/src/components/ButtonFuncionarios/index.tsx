import { Button } from "react-bootstrap";
import { Link } from "react-router-dom";

import "bootstrap/dist/css/bootstrap.min.css";

type Props = {
  idEmpresa: number;
};

function ButtonFuncionarios(idEmpresa: Props) {
  var link = `/empresa/${idEmpresa.idEmpresa}`;
  return (
    <Button type="button" className="btn btn-success">
      <Link to={link} style={{ textDecoration: 'none', color: 'white' }}>Funcionarios</Link>
    </Button>
  );
}
export default ButtonFuncionarios;
