import { Container, Button, Form, Row, Col } from "react-bootstrap";
import { Link } from "react-router-dom";
import NavBar from "../../components/NavBar";
import TableFuncionarios from "../../components/TableFuncionarios";
import { useParams } from "react-router-dom";
import axios from "axios";
import { useState } from "react";

type EmpresaParams = {
  id?: string | undefined;
};

function Empresa() {
  const [nome, setNome] = useState("");
  const [cargo, setCargo] = useState("");
  const [salario, setSalario] = useState("");

  const { id } = useParams<EmpresaParams>();

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    axios
      .post(`https://quero2-desafio.herokuapp.com/funcionarios/`, {
        nome: nome,
        cargo: cargo,
        salario: salario,
        empresa_id: id,
      })
      .then((res) => {
        console.log(res);
        console.log(res.data);
      });
  };

  const handlerChangeName = (event: any) => {
    setNome(event.target.value);
  };

  const handlerChangeCargo = (event: any) => {
    setCargo(event.target.value);
  };

  const handlerChangeSalario = (event: any) => {
    setSalario(event.target.value);
  };

  return (
    <>
      <Container>
        <NavBar />
        <h1>Quero2</h1>
        <h2>Rua teste</h2>
        <h3>Funcionarios</h3>
        <Form onSubmit={handleSubmit}>
          <Row>
            <Col>
              <Form.Control
                placeholder="Nome"
                value={nome}
                onChange={handlerChangeName}
              />
            </Col>
            <Col>
              <Form.Control
                placeholder="Cargo"
                value={cargo}
                onChange={handlerChangeCargo}
              />
            </Col>
            <Col>
              <Form.Control
                placeholder="Salário"
                value={salario}
                onChange={handlerChangeSalario}
              />
            </Col>
            <Col>
              <Button variant="success" type="submit">
                Adicionar
              </Button>
            </Col>
          </Row>
        </Form>
        <TableFuncionarios idEmpresa={id} />
      </Container>
    </>
  );
}

export default Empresa;
