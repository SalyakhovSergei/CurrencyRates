using System;
using System.Threading.Tasks;
using ClassLibrary1;
using CRB.BL.ReceivingDataServices.Interfaces;
using CRB.BL.Services;
using CRB.DA.Models;
using Microsoft.AspNetCore.Mvc;
using Serilog;

namespace centros_ref_book.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class RatesCBController: ControllerBase 
    {
        private readonly ISearchService _searchService;

        public RatesCBController(ISearchService searchService)
        {
            _searchService = searchService;
        }
        
        [HttpGet]
        [Route("SearchData/{code}/{date?}")]
        public async Task<ActionResult<ResponseModel>> SearchData(string code, DateTime? date)
        {
            ResponseModel _response = _searchService.SearchByCode(code, date);

            if (_response.Price is null || _response.Code is null)
            {
                return Ok(StatusCode(204));
            }

            return Ok(_response);
        }

        private bool CheckSearchLoop(ResponseModel response, int count)
        {
            return (response?.Code != null || response?.Price != null || count == 30);
        }
    }
}