using CRB.DA.Models;
using System;

namespace CRB.BL.Services
{
    public interface ISearchService
    {
        ResponseModel SearchByCode(string code, DateTime? date);
    }
}