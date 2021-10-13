import { Container, Button, Form, Row, Col } from "react-bootstrap";
import { Link } from "react-router-dom";
import NavBar from "../../components/NavBar";
import TableFuncionarios from "../../components/TableFuncionarios";
import { useParams } from "react-router-dom";

type EmpresaParams = {
  id?: string | undefined;
};

function Empresa() {
  const {id} = useParams<EmpresaParams>();

  return (
    <>
      <Container>
        <NavBar />
        <h1>Quero2</h1>
        <h2>Rua teste</h2>
        <h3>Funcionarios</h3>
        <Form>
          <Row>
            <Col>
              <Form.Control placeholder="Nome" />
            </Col>
            <Col>
              <Form.Control placeholder="Cargo" />
            </Col>
            <Col>
              <Form.Control placeholder="Salário" />
            </Col>
            <Col>
              <Button variant="success">Adicionar</Button>
            </Col>
          </Row>
        </Form>
        <TableFuncionarios idEmpresa={id}/>
      </Container>
    </>
  );
}

export default Empresa;
