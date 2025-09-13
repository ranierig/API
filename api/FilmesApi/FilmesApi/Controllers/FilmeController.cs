using Microsoft.AspNetCore.Components;
using Microsoft.AspNetCore.Mvc;
using FilmesApi.Models;

using RouteAttribute = Microsoft.AspNetCore.Components.RouteAttribute;

namespace FilmesApi.Controllers; 
[ApiController]
[Route("[controller]")]
public class FilmeController : ControllerBase {
    private readonly ILogger<FilmeController> _logger;
    public FilmeController(ILogger<FilmeController> logger) {
        _logger = logger;
    }
    private static List<Filme> filmes = new List<Filme>();
    private static int _idFilme = 0;
    [HttpPost("filmes")]
    public IActionResult AdicionaFilme ([FromBody] Filme filme) {
        filme.IdFilme = _idFilme++; 
        filmes.Add(filme);
        _logger.LogInformation($"Titulo: {filme.Titulo}");
        _logger.LogInformation($"Tempo:  {filme.Tempo.ToString()}");
        _logger.LogInformation($"Genero: {filme.Genero}");
        return Ok(_idFilme);  
    }
    [HttpGet("filmes")]
    public IEnumerable<Filme> RetornaFilmes() {
            return filmes;
        }
    [HttpGet("filmes/{id}")]
    public Filme? RetornaFilmesId(int id) {
        return filmes.FirstOrDefault(filme => filme.IdFilme == id);
    }
}
