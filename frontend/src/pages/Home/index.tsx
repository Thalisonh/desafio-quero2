import axios from "axios";
import { useState } from "react";
import { Button, Col, Container, Form, Row } from "react-bootstrap";
import NavBar from "../../components/NavBar";
import TableEmpresa from "../../components/TableEmpresas";

function Home() {
  const [nome, setNome] = useState("");
  const [telefone, setTelefone] = useState("");

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    axios
      .post(`https://desafio-quero2.vercel.app/empresas/`, {
        nome: nome,
        telefone: telefone,
      })
      .then((res) => {
        console.log(res);
        console.log(res.data);
      });
  };

  const handlerChangeName = (event: any) => {
    setNome(event.target.value);
  };

  const handlerChangeTelefone = (event: any) => {
    setTelefone(event.target.value);
  };

  return (
    <>
      <Container>
        <NavBar />
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
                placeholder="Telefone"
                value={telefone}
                onChange={handlerChangeTelefone}
              />
            </Col>
            <Col>
              <Button variant="success" type="submit">
                Adicionar
              </Button>
            </Col>
          </Row>
        </Form>
        <TableEmpresa />
      </Container>
    </>
  );
}

export default Home;
