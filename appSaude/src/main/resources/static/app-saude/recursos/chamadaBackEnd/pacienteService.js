import { ApiService } from "./api.js";

class PacienteService extends ApiService {

    getPerfil() {
        return this.fetch("/pacientes/perfil");
    }

    atualizarPerfil(id, dto) {
        return this.fetch("/pacientes/perfil", {
            method: "PUT",
            body: JSON.stringify(dto),
        });
    }


     atualizarSenha(id, senhaAtual, novaSenha) {
        return this.fetch("/pacientes/perfil/senha", {
            method: "PATCH",
            body: JSON.stringify({ senhaAtual, novaSenha }),
        });
    }
}

export const pacienteService = new PacienteService();
