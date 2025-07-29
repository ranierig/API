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
    [HttpPost("filmes")]
    public IActionResult AdicionaFilme ([FromBody] Filme filme) {
        filmes.Add(filme);
        _logger.LogInformation($"Titulo: {filme.Titulo}");
        _logger.LogInformation($"Tempo:  {filme.Tempo.ToString()}");
        _logger.LogInformation($"Genero: {filme.Genero}");
        return Ok(filmes.Count);  
    }
}
