export type Funcionario = {
    id: number,
    nome: string,
    cargo: string,
    salario: number,
    nomeEmpresa: string,
}

export type FuncionarioPage = {
    content?: Funcionario[];
    last: boolean;
    totalPages: number;
    totalElements: number;
    first: boolean;
    size?: number;
    number: number;
    numberOfElements?: number;
    empty?: boolean;
}