import { BrowserRouter, Route, Switch } from "react-router-dom";
import App from "./App";
import Empresa from "./pages/Empresa";

import "bootstrap/dist/css/bootstrap.min.css";
import NovaEmpresa from "./pages/Enderecos";
import Enderecos from "./pages/Enderecos";

function Routes() {
  return (
    <BrowserRouter>
      <Switch>
        <Route path="/" exact>
          <App />
        </Route>
        <Route path="/empresa/:id" component={Empresa}>
        </Route>
        <Route path="/endereco/:id" component={Enderecos}>
        </Route>
      </Switch>
    </BrowserRouter>
  );
}

export default Routes;
