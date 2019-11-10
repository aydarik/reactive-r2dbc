INSERT INTO public.users (id, first_name, last_name, email, created_on, last_login)
VALUES (1, 'User', 'Test', 'user.test@acme.com', '2019-10-28 00:00:00', null)
ON CONFLICT (id) DO NOTHING;