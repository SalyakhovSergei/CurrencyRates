using CRB.DA.Models;
using Serilog;
using System;

namespace CRB.BL.Services
{
    public class SearchService: ISearchService
    {
        private readonly ICurrencyService _currencyService;
        private readonly IMetallService _metallService;

        public SearchService(ICurrencyService currencyService, 
                                    IMetallService metallService)
        {
            _currencyService = currencyService;
            _metallService = metallService;
        }

        public ResponseModel SearchByCode(string code, DateTime? date)
        {
            ResponseModel _response = new ResponseModel();
            int loopCount = 0;

            date ??= DateTime.Today;

            bool isNumericCode = int.TryParse(code, out int numericCode);

            while (!CheckSearchLoop(_response, loopCount))
            {
                try
                {
                    if (isNumericCode)
                    {
                        Log.Information($"Get currency request by NumericCode for {code} on date: {date}");
                        _response = _currencyService.GetResponseByNumericCode(code, date);
                    }

                    if ((_response is null || _response.Code is null || _response.Price is null) && !isNumericCode)
                    {
                        Log.Information($"Get metal request for {code} on date: {date}");
                        _response = _metallService.GetResponse(code, date);
                    }
                }
                catch (Exception ex)
                {
                    Log.Error(ex.Message);
                }
                date = date.Value.AddDays(-1);
                loopCount++;
            }

            Log.Information("Query finished");

            return _response;
        }


        private bool CheckSearchLoop(ResponseModel response, int count)
        {
            return (response?.Code != null || response?.Price != null || count == 30);
        }
    }
}