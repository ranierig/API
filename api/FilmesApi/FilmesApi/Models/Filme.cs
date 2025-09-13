using System.ComponentModel.DataAnnotations;

namespace FilmesApi.Models; 
public class Filme {
    [Required(ErrorMessage = "Título é obrigatório.")]
    public int IdFilme { get; set; }
    public string Titulo { get; set; }
    [Required(ErrorMessage = "Genero é obrigatório.")]
    [MaxLength(50, ErrorMessage = "Tamanho máximo do gênero é de 50 caracteres.")]
    public string Genero { get; set; }
    [Required]
    [Range(70, 600, ErrorMessage = "A duaraçã deve ser entre 70 e 600 minutos.")]
    public int Tempo { get; set; }
}
