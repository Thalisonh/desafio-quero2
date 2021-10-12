import { BrowserRouter, Route, Switch } from "react-router-dom";
import App from "./App";
import Empresa from "./pages/Empresa";

import "bootstrap/dist/css/bootstrap.min.css";
import NovaEmpresa from "./pages/NovaEmpresa";

function Routes() {
  return (
    <BrowserRouter>
      <Switch>
        <Route path="/" exact>
          <App />
        </Route>
        <Route path="/empresa/:id">
          <Empresa/>
        </Route>
        <Route path="/cadastrar">
          <NovaEmpresa />
        </Route>
      </Switch>
    </BrowserRouter>
  );
}

export default Routes;
