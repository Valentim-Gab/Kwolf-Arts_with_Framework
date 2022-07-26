let photo = document.getElementById('imgArteUp')
let file = document.getElementById('arteUp')
let imagem = document.getElementById('imagem')
let containerCadastro = document.getElementById('containerCadastro')
let tituloCadastro = document.getElementById('tituloCadastro')
let tituloLogin = document.getElementById('tituloLogin')
let containerLogin = document.getElementById('containerLogin')
let btnCadastrar
let tipo_conta = document.getElementById('tipo_conta')
let inputDeletar = document.getElementById('inputDeletar')
let inputDeletarConfirmar = document.getElementById('inputDeletarConfirmar')
let primeiro_nome = document.getElementById('primeiro_nome');
let segundo_nome = document.getElementById('segundo_nome');
let email = document.getElementById('email');
let cpf = document.getElementById('cpf');
let senha = document.getElementById('senha');
let rSenha = document.getElementById('rSenha');
let cadastrarUsuario = document.getElementById('cadastrarUsuario');
let cadastrarUsuarioConfirmar = document.getElementById('cadastrarUsuarioConfirmar');
let editarUsuarioCampos = document.getElementById('editarUsuarioCampos');

photo.addEventListener('click', () => {
    file.click()
})

file.addEventListener('change', (e) => {
    let reader = new FileReader()

    reader.onload = () => {
        photo.src = reader.result
        console.log(photo.src)
        imagem.value = photo.src;
        console.log(imagem.value)
    }
    reader.readAsDataURL(file.files[0])
    imagem.value = photo.src;
})

function cadastrarComprador() {
    tituloCadastro.innerHTML = 'Cadastrando Comprador'
    containerCadastro.style.display = 'block'
    containerCadastro.style.borderBlockColor = 'white'
    btnCadastrar = document.getElementById('btnCadastrar')
    btnCadastrar.value = 'C'
}

function cadastrarArtista() {  
    tituloCadastro.innerHTML = 'Cadastrando Artista'
    containerCadastro.style.display = 'block'
    btnCadastrar = document.getElementById('btnCadastrar')
    btnCadastrar.value = 'A'
}

function loginComprador() {
    tituloLogin.innerHTML = 'Logar como Comprador'
    containerLogin.style.display = 'block'
    tipo_conta.value = 'C'
}

function loginArtista() {
    tituloLogin.innerHTML = 'Logar como Artista'
    containerLogin.style.display = 'block'
    tipo_conta.value = 'A'
}

function deletarConta(){
    Swal.fire({
        title: 'Tem certeza que deseja deletar sua conta?',
        text: "Essa ação não pode ser revertida!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'SIM, DELETAR',
        cancelButtonText: 'CANCELAR'
    }).then((result) => {
        if (result.isConfirmed) {
            inputDeletarConfirmar.click();
        }
    })
}

function cadastrarUsuarioCampos(acao) {
    if (primeiro_nome.value != '') {
        if (segundo_nome.value != '') {
            if (email.value != '' ) {
                if (cpf.value != '' && cpf.value.length == 14) {
                    if (senha.value != '') {
                        if (senha.value == rSenha.value) {
                            switch (acao) {
                                case 'cadastrar':
                                    cadastrarUsuarioConfirmar.click();
                                    break;
                                case 'editar':
                                    editarUsuarioCampos.click();
                                    break;
                            }
                        } else {
                            campoComErro('As senhas não coincidem');
                        }
                    } else {
                        campoComErro('Senha não pode estar vazia');
                    }
                } else {
                    campoComErro('CPF inválido');
                }
            } else {
                campoComErro('Email não pode estar vazio');
            }
        } else {
            campoComErro('Segundo nome não pode estar vazio');
        }
    } else {
        campoComErro('Primeiro nome não pode estar vazio');
    }
}

function campoComErro(mensagem) {
    Swal.fire({
        icon: 'error',
        title: 'Algo deu errado',
        text: mensagem
    })
}
