using CENTROS.Core.DA.Interfaces;
using CENTROS.Core.DA.PgSql;
using CRB.BL.ReceivingDataServices.Interfaces;
using CRB.BL.ReceivingDataServices.Services;
using CRB.BL.Services;
using CRB.DA.CacheModel;
using CRB.DA.Interfaces;
using CRB.DA.Repositories;
using Microsoft.Extensions.DependencyInjection;

namespace centros_ref_book.Implementations
{
    public static class RegisterImplementations
    {
        public static void RegisterImplementation(this IServiceCollection services)
        {
            //работа с БД
            services.AddScoped<IConnectionFactory, PgSqlConnectionFactory>();
            services.AddScoped<IConnectionResolver, PgSqlConnectionResolver>();

            //работа с данными
            services.AddScoped<ICurrencyRepository, CurrencyRepository>();
            services.AddScoped<IMetallRepository, MetallsRepository>();
            services.AddScoped<ICurrencyService, CurrencyService>();
            services.AddScoped<IMetallService, MetallsService>();
            services.AddScoped<ICacheModel, CacheModel>();
            services.AddScoped<ISearchService, SearchService>();

            services.AddMemoryCache();

            //работа с источником
            services.AddSingleton<IMetallReciever, MetallReceiver>();
            services.AddSingleton<ICurrencyReceiver, CurrencyReceiver>();
            
            DapperCustomExtensions.SetFormatter(new PostgresAdapter());
        }
    }
}
