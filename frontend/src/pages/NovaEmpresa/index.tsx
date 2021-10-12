import { Container, Button, Form, Row, Col } from "react-bootstrap";
import { Link } from "react-router-dom";
import NavBar from "../../components/NavBar";
import TableFuncionarios from "../../components/TableFuncionarios";

function NovaEmpresa() {
  return (
    <>
      <Container>
        <NavBar />
        <Form>
          <Row>
            <Col>
              <Form.Control placeholder="Nome" />
            </Col>
            <Col>
              <Form.Control placeholder="Telefone" />
            </Col>
          </Row>
          <Row>
            <Col>
              <Form.Control placeholder="Cep" />
            </Col>
            <Col>
              <Form.Control placeholder="Rua" />
            </Col>
            <Col>
              <Form.Control placeholder="Número" />
            </Col>
          </Row>
          <Row>
            <Col>
              <Form.Control placeholder="Complemento" />
            </Col>
            <Col>
              <Form.Control placeholder="Bairro" />
            </Col>
            <Col>
              <Form.Control placeholder="Cidade" />
            </Col>
            <Col>
              <Form.Control placeholder="UF" />
            </Col>
          </Row>
          <Button variant="success">Adicionar</Button>
        </Form>
      </Container>
    </>
  );
}

export default NovaEmpresa;
