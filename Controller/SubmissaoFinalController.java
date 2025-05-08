package com.example.hackaton.Cadastro_Evento.Controller;

@RestController
@RequestMapping("/revisoes-finais")
public class SubmissaoFinalController {

    private final RevisaoArtigoService revisaoArtigoService;

    public SubmissaoFinalController(RevisaoArtigoService revisaoArtigoService) {
        this.revisaoArtigoService = revisaoArtigoService;
    }

    @PostMapping
    public ResponseEntity<?> enviarFinal(@RequestBody RevisaoArtigo revisao) {
        try {
            return ResponseEntity.ok(revisaoArtigoService.enviarRevisao(revisao));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
