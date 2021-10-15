import axios from "axios";
import { useState } from "react";
import { Container, Button, Form, Row, Col } from "react-bootstrap";
import NavBar from "../../components/NavBar";

function Enderecos() {
  const [cep, setCep] = useState("");
  const [rua, setRua] = useState("");
  const [numero, setNumero] = useState("");
  const [complemento, setComplemento] = useState("");
  const [bairro, setBairro] = useState("");
  const [cidade, setCidade] = useState("");
  const [uf, setUf] = useState("");

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    axios.get(`https://quero2-desafio.herokuapp.com/${cep}`).then((res) => {
      setBairro(res.data["bairro"]);
      setCidade(res.data["localidade"]);
      setUf(res.data["uf"]);
      setRua(res.data["logradouro"]);
      console.log(res.data["bairro"]);
      console.log(res.data);
    });
  };

  const handleSubmitEndereco = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    axios
      .post(`https://quero2-desafio.herokuapp.com/`, {
        cep: cep,
        numero: numero,
        complemento: complemento,
        empresa_id: 4,
      })
      .then((res) => {
        console.log(res);
        console.log(res.data);
      });
  };

  const handlerChangeCep = (event: any) => {
    setCep(event.target.value);
  };

  const handlerChangeComplemento = (event: any) => {
    setComplemento(event.target.value);
  };

  const handlerChangeNumero = (event: any) => {
    setNumero(event.target.value);
  };

  return (
    <>
      <Container>
        <NavBar />
        <form onSubmit={handleSubmit}>
          <Row>
            <Col>
              <Form.Control
                placeholder="Cep"
                value={cep}
                onChange={handlerChangeCep}
              />
            </Col>
            <Col>
              <Button type="submit" variant="success">
                Buscar
              </Button>
            </Col>
          </Row>
        </form>
        <Form onSubmit={handleSubmitEndereco}>
          <Row>
            <Col>
              <Form.Control placeholder="Rua" value={rua} />
            </Col>
            <Col>
              <Form.Control placeholder="Número" value={numero} onChange={handlerChangeNumero}/>
            </Col>
          </Row>
          <Row>
            <Col>
              <Form.Control placeholder="Complemento" value={complemento} onChange={handlerChangeComplemento}/>
            </Col>
            <Col>
              <Form.Control placeholder="Bairro" value={bairro} />
            </Col>
            <Col>
              <Form.Control placeholder="Cidade" value={cidade} />
            </Col>
            <Col>
              <Form.Control placeholder="UF" value={uf} />
            </Col>
          </Row>
          <Button type="submit" variant="success">Adicionar</Button>
        </Form>
      </Container>
    </>
  );
}

export default Enderecos;
